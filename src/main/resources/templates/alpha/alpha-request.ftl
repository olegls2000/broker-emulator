<#import "../common/page.ftl" as common>

<@common.page>

    <form action="/alpha/statistics" method="post">

        <div class="form-group">
            <label for="sticker">Company Sticker:</label>
            <input type="text" class="form-control" aria-describedby="stickerHelp" name="sticker">
            <small id="stickerHelp" class="form-text text-muted">Please enter company Sticker.</small>
        </div>
        <div class="form-group">
            <label for="time-period">Time Period:</label>
            <select id="time-period" name="timePeriod" class="form-control">
                <option selected>DAY</option>
                <option>WEEK</option>
                <option>MONTH</option>
                <option>YEAR</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Request Statistics</button>
    </form>

</@common.page>