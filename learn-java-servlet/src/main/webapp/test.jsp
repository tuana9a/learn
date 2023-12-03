<html>
    <head>
        <title>Jsp</title>
    </head>
    <body>
        <h1></h1>
        <h3><b>Time: <% out.println(new java.util.Date()); %></b></h3>
        <form action="/api/welcome" method="post">
            <input type="text" name="username" />
            <input type="submit" value="welcome" />
        </form>
        <script>
            const h1Element = document.getElementsByTagName("h1").item(0);
            fetch("/api/servlets/jsp")
                .then((resp) => resp.text())
                .then((text) => {
                    h1Element.innerText = "GET: " + text;
                });
        </script>
    </body>
</html>
