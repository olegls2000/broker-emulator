<#import "../common/page.ftl" as common>

<@common.page>
    <div class="row">
        <div class="col-3">col-Left</div>

        <div class="col-6">
            <form action="/user/registration" method="post">

                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" aria-describedby="usernameHelp" name="username">
                    <small id="usernameHelp" class="form-text text-muted">We'll never share your username with anyone
                        else.</small>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" name="password">
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control"  name="email">
                </div>

                <label for="phone">Phone:</label>
                <input type="text" class="form-control"  name="phone">

                <label for="address">Address:</label>
                <input type="text" class="form-control"  name="address">

                <label for="firstName">First Name:</label>
                <input type="text" class="form-control"  name="firstName">

                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control"  name="lastName">

                <button type="submit" class="btn btn-primary">Registration</button>
            </form>
        </div>

        <div class="col-3">col-right</div>
    </div>
</@common.page>








