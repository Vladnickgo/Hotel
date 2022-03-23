<%--
  Created by IntelliJ IDEA.
  User: Computer
  Date: 19.03.2022
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <title>LoginPage</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light pb-2">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Hello Hotel</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs.jsp">AboutUs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contacts.jsp">Contacts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/loginPage.jsp">LogIn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/signIn.jsp">SignIn</a>
                </li>
            </ul>
            <form class="d-flex">
                <select class="form-select" aria-label="Default select example">
                    <%--                    <option selected>Open this select menu</option>--%>
                    <option value="1">укр</option>
                    <option value="2">eng</option>
                </select>
            </form>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row text-center">
        <div class="col-4"></div>
        <div class="col-4">
            <h1 class="mb-5">About Us</h1>
        </div>
        <div class="col-4"></div>
    </div>
</div>
<div class="container mt-1">
    <div class="row text-center">
        <div class="col-3"></div>
        <div class="col-6">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad architecto atque blanditiis commodi consequatur
            dolores eveniet ex exercitationem explicabo harum hic ipsam ipsum itaque maiores natus nesciunt nisi non
            nostrum obcaecati, odit placeat provident quia quibusdam quo reiciendis repellat reprehenderit suscipit
            tempore veritatis voluptas. Accusantium beatae consectetur corporis delectus error, explicabo ipsam itaque
            maiores perspiciatis. Doloremque enim pariatur quaerat recusandae sit. Accusantium, deserunt distinctio
            ducimus, facere facilis fuga hic ipsa laborum nesciunt obcaecati odit officiis perspiciatis possimus
            quibusdam, repudiandae sed totam veritatis. Consectetur corporis deserunt distinctio esse ex hic magnam
            magni provident quo repellat. A adipisci at commodi corporis doloribus ea est excepturi, facilis id maxime
            mollitia ratione soluta temporibus ullam voluptates. Doloribus ducimus enim fugiat iusto, nobis praesentium
            sunt. Eos illum porro praesentium similique voluptas. Asperiores assumenda, cupiditate debitis doloremque
            doloribus minima nam nulla porro quasi quis quisquam quo quos recusandae reiciendis reprehenderit ut
            voluptas voluptate. Accusamus assumenda blanditiis hic maiores neque nihil odit officiis sapiente velit?
            Accusamus accusantium aperiam asperiores corporis culpa dolorum earum esse ex fugiat illo iste iure iusto
            laboriosam magnam nesciunt nihil, nisi officiis recusandae reiciendis saepe sit, suscipit tempore unde
            veniam voluptate? Blanditiis doloribus harum rem sequi tenetur. Dicta explicabo in iure molestias saepe
            tempore. Dicta dignissimos earum, expedita illum, ipsum iste itaque laudantium libero magnam modi nesciunt
            nisi nulla officia officiis quam quidem, reprehenderit sapiente sint sunt ullam. Accusantium autem, esse
            omnis quia reiciendis similique tenetur. Ea eligendi incidunt laboriosam quisquam vero! Accusamus ad aliquam
            aliquid aspernatur deleniti harum modi nobis numquam quod repudiandae. Aliquam amet aperiam consequuntur
            corporis debitis ea, et fuga harum hic illum laudantium magni modi neque nihil non officia quidem, quis
            quisquam quo quod repellat reprehenderit repudiandae rerum sequi sint voluptates voluptatibus. Aperiam
            commodi impedit nesciunt nobis omnis rem repellat sed veritatis vero. Eius eum inventore odio qui soluta?
        </div>
        <div class="col-3"></div>
    </div>
</div>

</body>
</html>
