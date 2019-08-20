window.onload=function(){
    var app = new Vue({		// 对于Vue的使用一定要创建有一个vue的对象
        el: "#msgDiv" ,		// 定义要使用的html元素
        data: {				// 定义出要设置的数据内容
            loadMsg:"异步加载部门信息",
            members:[]  //因为数据是需要通过异步加载的，所以默认设置一个空数组
        },
        methods:{
            loadDept:function () {
                self=this;  //保存一下当前的this对象
                params=new URLSearchParams();  //定义一个参数的传递的对象
                params.append("dname","我的部门-");
                params.append("loc","我的地盘-");
                axios.post("member/list",params).then(function (response) {   //数据的回调处理
                    self.members=response.data;         //直接获取访问数据
                }).catch(
                    function (error) {
                        console.log(error);
                    }
                )
            }
        }
    });
}
