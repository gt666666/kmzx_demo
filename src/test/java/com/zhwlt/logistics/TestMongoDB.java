package com.zhwlt.logistics;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.mongodb.client.result.DeleteResult;
import com.zhwlt.logistics.pojo.CarInfo;
import com.zhwlt.logistics.pojo.Dept;
import javafx.scene.shape.Circle;
import org.apache.commons.collections.list.LazyList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/9/3
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMongoDB {
    private long end;
    private long start;
    @Resource
    private Dept dept;
    @Resource
    private CarInfo carInfo;

    @Resource
    MongoTemplate mongoTemplate;

    @Before
    public void before() {
        this.start = System.currentTimeMillis();
        System.out.println("测试开始");
    }

    @After
    public void after() {
        this.end = System.currentTimeMillis();
        System.out.println("测试结束，用时：" + DateUtil.formatBetween(this.end - this.start));
    }

    @Test
    public void insert() {
        Dept dept = new Dept();
        dept.setDeptno(1);
        dept.setDname("高挺" + 1);
        dept.setLoc("北京" + 1);
        mongoTemplate.save(dept);
    }

    @Test
    public void updateFirst() {
        Update update = new Update();
        Dept dept = new Dept();
        update.set("dme", "昆明111");
        update.set("loc", "上海");
        Criteria criteria = new Criteria();
        criteria.and("deptno").is(1);
        Query query = new Query(criteria);
        System.out.println("****************" + this.mongoTemplate.updateFirst(query, update, Dept.class));

    }

    @Test
    public void insertAll() {
        Dept dept = new Dept();
        dept.setDeptno(4);
        dept.setDname("高挺");
        dept.setLoc("北京");
        dept.setTime(new Date());
        mongoTemplate.insert(dept);
    }

    @Test
    public void findAll() {
        Query query = new Query(Criteria.where("deptno").is(4));
        List<Dept> all = mongoTemplate.find(query, Dept.class);
        Iterator<Dept> iter = all.iterator();
        while (iter.hasNext()) {
            Dept dept = iter.next();
            String sdf = new SimpleDateFormat("yyyy.MM.dd ").format(dept.getTime());
            System.out.println(sdf);
        }
    }

    @Test
    public void testList() {
        List list = new ArrayList();
        System.out.println("*********" + list.size());
    }

    @Test
    public void findById() {
        Query query = new Query(Criteria.where("_id").is("5d6dcc6a513b90b959f8ae19"));
        Dept dept = this.mongoTemplate.findOne(query, Dept.class);
        System.out.println(dept);
    }

    @Test
    public void remove() {
        Criteria criteria = new Criteria();
        criteria.and("_id").is("5d8c34e797a5821a10fe6a19");
        Query query = new Query(criteria);
        long deptno = this.mongoTemplate.remove(query, Dept.class).getDeletedCount();
        System.out.println(deptno);
    }

    @Test
    public void update() {
        Criteria criteria = new Criteria();
        criteria.and("_id").is("5d8c34e797a5821a10fe6a19");
        Query query = new Query(criteria);
        long deptno = this.mongoTemplate.remove(query, Dept.class).getDeletedCount();
        System.out.println(deptno);
    }

    @Test
    public void findByDeptno() {
        Criteria criteria = new Criteria();
        criteria.and("carNumber").is("云G90815");
        Query query = new Query(criteria);
        CarInfo depts = mongoTemplate.findOne(query, CarInfo.class);
        System.out.println(depts);
    }

    @Test
    public void test() {
        List<Dept> depts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Dept dept = new Dept();
            dept.setDeptno(i);
            dept.setDname("高挺" + i);
            dept.setLoc("北京" + i);
            depts.add(dept);
            System.out.println(dept);
            System.out.println(depts);
        }
    }

    @Test
    public void testGetCarInfo() {
        String path = "http://60.161.53.204:8088/StandardApiAction_queryUserVehicle.action?jsession=298d6901-ce04-4ee9-8082-fb3ac3eb8d77";
        String res = HttpUtil.post(path, "");
        JSONObject json = JSONUtil.parseObj(res);
        JSONArray vehicles = json.getJSONArray("vehicles");
        List<CarInfo> carInfos = new ArrayList<>();
        for (int i = 0; i < vehicles.size(); i++) {
            CarInfo carInfo = new CarInfo();
            JSONObject obj = vehicles.getJSONObject(i);
            carInfo.setCarNumber(obj.getStr("nm"));
            carInfo.setEquipment(obj.getJSONArray("dl").getJSONObject(0).getStr("id"));
            carInfos.add(carInfo);
        }
        mongoTemplate.insertAll(carInfos);
    }

    @Test
    public void weiZhi() {
        String path = "http://60.161.53.204:8088/StandardApiAction_vehicleStatus.action";
        Map<String, Object> map = new HashMap<>();
        map.put("jsession", "298d6901-ce04-4ee9-8082-fb3ac3eb8d77");
        map.put("vehiIdno", "云A5853挂");
        map.put("toMap", 2);
        map.put("geoaddress", 1);
        String res = HttpUtil.post(path, map);
        JSONObject json = JSONUtil.parseObj(res);
        JSONArray infos = json.getJSONArray("infos");
        System.out.println(infos);
        JSONObject info = infos.getJSONObject(0);
        carInfo.setNewTime(info.getLong("tm"));
        carInfo.setLoc(info.getStr("pos"));
        carInfo.setCarNumber(info.getStr("vi"));
        System.out.println(carInfo.getCarNumber());
        this.mongoTemplate.insert(carInfo);
    }

    @Test
    public void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(1568515522000L);
        System.out.println(format + "***************");
    }

    @Test
    public void CollUtil() {
        if (CollUtil.toList(4, 5, 8, 9, 10).contains(1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        for (int i = 1; i < 3; i++) {
            for (int x = 1; x < 1000; x++) {
                System.out.println(111);
            }
        }
    }

    @Test
    public void simpleDate() throws ParseException {
        String str = "2019-09-11 10:11:35.345";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d = sdf.parse(str);
    }

    @Test
    public void testIf() {
        int i = 2;
        if (i == 1) {
            System.out.println(1);
        } else if (1 == 3) {
            System.out.println(2);
        } else {
            System.out.println(4 + "111111111111111111111111111");
        }
        double f = 111231.5585;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(new BigDecimal(185 / 188.0).setScale(3, BigDecimal.ROUND_HALF_UP));
        int diliverNum = 3;//举例子的变量
        int queryMailNum = 9;//举例子的变量
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后1位
        numberFormat.setMaximumFractionDigits(1);
        String result = numberFormat.format((float) diliverNum / (float) queryMailNum * 100);
        System.out.println(result);
    }

    @Test
    public void ExcelUtil() {
        ExcelReader reader = ExcelUtil.getReader("E:\\jxls\\员工表.xls");
        List<Map<String, Object>> maps = reader.readAll();
        Iterator<Map<String, Object>> iterator = maps.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> next = iterator.next();
            for (Map.Entry<String, Object> me : next.entrySet()) {
                System.out.println(me.getKey() + "    " + me.getValue());
            }
        }
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王二");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //Iterator形式输出
        Iterator<Map.Entry<String, String>> iter = entries.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> next = iter.next();
            System.out.println(next.getKey() + "   " + next.getValue());
        }
        //foreach输出map
        for (Map.Entry<String, String> me : map.entrySet()) {
            System.out.println(me.getKey() + "   " + me.getValue());
        }
    }

    @Test
    public void testTime() throws Exception {
        String str = "2019-09-17 16:19:56.0";
        System.out.println();
    }

    @Test
    public void getFiledName() {
        Query  query=new Query(Criteria.where("deptno").is(2));
        Update update = new Update();
        update.set("dname","高挺111");
        System.out.println(this.mongoTemplate.updateFirst(query, update,Dept.class));
    }
}
