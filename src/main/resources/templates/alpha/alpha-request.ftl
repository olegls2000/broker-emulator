<#import "../common/page.ftl" as common>

<@common.page>
    <form action="/alpha/statistics" method="post">
        <div class="form-group">
            <label for="sticker">Company Sticker:</label>
            <input type="text" value="IBM" class="form-control" aria-describedby="stickerHelp" name="sticker">
            <small id="stickerHelp" class="form-text text-muted">Please enter company Sticker.</small>
        </div>
        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" value="2006-01-21" class="form-control" aria-describedby="endDateHelp" name="endDate">
            <small id="endDateHelp" class="form-text text-muted">Please enter End DAte of Statistic.</small>
        </div>
        <div class="form-group">
            <label for="time-period">Time Period:</label>
            <select id="time-period" name="timePeriod" class="form-control">
                <option value="TIME_SERIES_DAILY">DAY</option>
                <option value="TIME_SERIES_WEEKLY" selected>>WEEK</option>
                <option value="TIME_SERIES_MONTHLY">MONTH</option>
                <option value="TIME_SERIES_YEARLY">YEAR</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Request Statistics</button>
    </form>
</@common.page>