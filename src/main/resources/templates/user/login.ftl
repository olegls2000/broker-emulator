<#import "../common/page.ftl" as common>

<@common.page>
    <form action="/login" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username">

        <label for="password">Password:</label>
        <input type="password" name="password">

        <input type="submit" value="Login">
    </form>
</@common.page>