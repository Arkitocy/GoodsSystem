<%--
  Created by IntelliJ IDEA.
  User: zsj55
  Date: 2019/7/22
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="Service.ProductService" %>
<%@ page import="Entity.Product" %>
<%@ page import="Service.CategoryService" %>
<%@ page import="Entity.Category" %>
<html>


<head>
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>Home</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.html");
    }
%>

<!-- ============================================================== -->
<!-- Preloader - style you can find in spinners.css -->
<!-- ============================================================== -->
<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg>
</div>
<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
<div id="main-wrapper">
    <!-- ============================================================== -->
    <!-- Topbar header - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
            <!-- ============================================================== -->
            <!-- Logo -->
            <!-- ============================================================== -->
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp">
                    <!-- Logo icon -->
                    <b>
                        <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                        <!-- Dark Logo icon -->
                        <img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo"/>

                    </b>
                    <!--End Logo icon -->
                    <!-- Logo text -->
                    <span>
                            <!-- dark Logo text -->
                            <img src="assets/images/logo-text.png" alt="homepage" class="dark-logo"/>
                        </span>
                </a>
            </div>
            <!-- ============================================================== -->
            <!-- End Logo -->
            <!-- ============================================================== -->
            <div class="navbar-collapse">
                <!-- ============================================================== -->
                <!-- toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav mr-auto mt-md-0 ">
                    <!-- This is  -->
                    <li class="nav-item"><a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark"
                                            href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                    <li class="nav-item hidden-sm-down">
                        <form class="app-search p-l-20">
                            <input type="text" class="form-control" placeholder="Search for..."> <a class="srh-btn"><i
                                class="ti-search"></i></a>
                        </form>
                    </li>
                </ul>
                <!-- ============================================================== -->
                <!-- User profile and search -->
                <!-- ============================================================== -->
                <ul class="navbar-nav my-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href=""
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=username%>
                        </a>
                        <a href="login.html" class="btn btn-danger">登出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- ============================================================== -->
    <!-- End Topbar header -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <aside class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
            <!-- Sidebar navigation-->
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li>
                        <a href="index.jsp" class="waves-effect"><i class="fa fa-clock-o m-r-10" aria-hidden="true"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="index2.jsp" class="waves-effect"><i class="fa fa-clock-o m-r-10"
                                                                     aria-hidden="true"></i>添加商品</a>
                    </li>
                    <li>
                        <a href="index3.jsp" class="waves-effect"><i class="fa fa-clock-o m-r-10"
                                                                     aria-hidden="true"></i>商品出库</a>
                    </li>
                </ul>

            </nav>
            <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
    </aside>
    <!-- ============================================================== -->
    <!-- End Left Sidebar - style you can find in sidebar.scss  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Page wrapper  -->
    <!-- ============================================================== -->
    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="row page-titles">
                <div class="col-md-6 col-8 align-self-center">
                    <h3 class="text-themecolor m-b-0 m-t-0">Dashboard</h3>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <!-- Row -->
            <form class="form-inline" action="ProductSelectServlet">
                <label>商品名</label>
                <input type="text" class="form-control" id="name" name="name">
                <button type="submit" class="btn btn-primary" name="btn">查询</button>
            </form>

            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>商品名</th>
                        <th>类型</th>
                        <th>生产日期</th>
                        <th>保质期</th>
                        <th>价格</th>
                        <th>库存</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ProductService ps = new ProductService();
                        ArrayList<Product> a = (ArrayList<Product>) session.getAttribute("productlist");
                        if (a == null) {
                            a = new ArrayList();
                        }
                        for (int i = 0; i < a.size(); i++) {
                            Product p = a.get(i);

                    %>
                    <tr>
                        <td><%=p.getId()%>
                        </td>
                        <td><%=p.getName()%>
                        </td>
                        <td><%=p.getCategory()%>
                        </td>
                        <td><%=p.getProductiondate()%>
                        </td>
                        <td><%=p.getOutdate()%>
                        </td>
                        <td><%=p.getPrice()%>
                        </td>
                        <td><%=p.getAmount()%>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" name="changebtn" id="<%=p.getId() %>">
                                编辑
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" name="addbtn" id="<%=p.getId() %>">
                                修改库存
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" name="deletebtn" id="<%=p.getId() %>">
                                删除商品
                            </button>
                        </td>
                    </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
            <!-- Row -->
            <!-- ============================================================== -->
            <!-- End PAge Content -->

            <div class="modal fade" id="modalhwdetail">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- 模态框头部 -->
                        <div class="modal-header">
                            <h4 class="modal-title">编辑货物</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- 模态框主体 -->
                        <div class="modal-body">
                            <form action="UpdateServlet">
                                <div class="form-group" hidden="hidden">
                                    <p>id</p>
                                    <input type="text" class="form-control" id="id" name="id">
                                </div>
                                <div class="form-group">
                                    <p>名称</p>
                                    <input type="text" class="form-control" id="productname" name="name">
                                </div>
                                <div class="form-group">
                                    <label>类型:</label>
                                    <select class="form-control" name="category" id="category">
                                        <%
                                            CategoryService cs = new CategoryService();
                                            ArrayList<Category> ac = cs.showCategory();
                                            for (int i = 0; i < ac.size(); i++) {
                                        %>
                                        <option value='<%=ac.get(i).getName()%>'><%=ac.get(i).getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <p>生产日期</p>
                                    <input type="date" class="form-control" id="productiondate" name="productiondate">
                                </div>
                                <div class="form-group">
                                    <p>过期</p>
                                    <input type="date" class="form-control" id="outdate" name="outdate">
                                </div>
                                <div class="form-group">
                                    <p>价格</p>
                                    <input type="text" class="form-control" id="price" name="price">
                                </div>
                                <div class="form-group">
                                    <p>库存</p>
                                    <input type="text" class="form-control" id="amount" name="amount">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary" name="btnn">修改</button>
                                </div>
                            </form>
                        </div>

                        <!-- 模态框底部 -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        </div>

                    </div>
                </div>
            </div>

            <!-- ============================================================== -->
        </div>


        <!-- ============================================================== -->
        <!-- End Container fluid  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- End footer -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Page wrapper  -->
    <!-- ============================================================== -->
</div>

<script type="text/javascript">
    $(document).ready(function () {
        function SimpleDateFormat(pattern){
            var fmt = new Object();
            fmt.pattern = pattern;

            fmt.parse = function(source){
                try{
                    return new Date(source);
                }catch(e){
                    console.log("字符串 "+source+" 转时间格式失败！");
                    return null;
                }
            };

            fmt.format = function(date){
                if(typeof(date) == "undefined" || date == null || date==""){
                    return "";
                }

                try{
                    date = new Date(date);
                }catch(e){
                    console.log("时间 "+date+" 格式化失败！");
                    return "";
                }

                var strTime = this.pattern;//时间表达式的正则

                var o = {
                    "M+": date.getMonth() + 1, //月份
                    "d+": date.getDate(), //日
                    "H+": date.getHours(), //小时
                    "m+": date.getMinutes(), //分
                    "s+": date.getSeconds(), //秒
                    "q+": Math.floor((date.getMonth() + 3) / 3), //季度
                    "S": date.getMilliseconds() //毫秒
                };

                if (/(y+)/.test(strTime)){
                    strTime = strTime
                        .replace(RegExp.$1, (date.getFullYear() + "")
                            .substr(4 - RegExp.$1.length));
                }
                for (var k in o){
                    if (new RegExp("(" + k + ")").test(strTime)){
                        strTime = strTime.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }

                return strTime;
            };
            return fmt;
        }

        $("button[name='deletebtn']").click(function () {
            var id = this.id;
            $.getJSON("DeleteServlet", {id: id}, function (json) {
            })
            $("button[name='btn']").trigger('click');
        })

        $("button[name='addbtn']").click(function () {
            var id = this.id;
            var num = prompt("出库商品数量", "");

            $.getJSON("AddAmountServlet", {id: id, num: num}, function (json) {
            })
            $("button[name='btn']").trigger('click');

        })

        $("button[name='changebtn']").click(function () {
            var id = this.id
            var fmt = SimpleDateFormat("yyyy-MM-dd");
            $.getJSON("ChangeAccountServlet", {id: id}, function (json) {
                $("#changebtn").empty();
                for(var key in json) {
                    $("#id").attr("value",json[key].id);
                    $("#category").attr("value",json[key].category);
                    $("#productname").attr("value",json[key].name);
                    $("#productiondate").attr("value",fmt.format(json[key].productiondate));
                    $("#outdate").attr("value",fmt.format(json[key].outdate));
                    $("#price").attr("value",json[key].price);
                    $("#amount").attr("value",json[key].amount);
                }
                $('#modalhwdetail').modal("show");
                $("button[name='btnn']").click(function () {
                    $("button[name='btn']").trigger('click');
                })
            })
        })


    })

</script>
<!-- ============================================================== -->
<!-- End Wrapper -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="assets/plugins/bootstrap/js/tether.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- slimscrollbar scrollbar JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!--Menu sidebar -->
<script src="js/sidebarmenu.js"></script>
<!--stickey kit -->
<script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<!--Custom JavaScript -->
<script src="js/custom.min.js"></script>
<!-- ============================================================== -->
<!-- This page plugins -->
<!-- ============================================================== -->
<!-- Flot Charts JavaScript -->
<script src="assets/plugins/flot/jquery.flot.js"></script>
<script src="assets/plugins/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
<script src="js/flot-data.js"></script>
<!-- ============================================================== -->
<!-- Style switcher -->
<!-- ============================================================== -->
<script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>
</html>
