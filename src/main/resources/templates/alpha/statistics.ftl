<#import "../common/page.ftl" as common>

<@common.page>
    <h2>Trades Items:</h2>

    <table>
        <tr>
            <th>Open</th>
            <th>High</th>
            <#--TODO.add another columns..-->
        </tr>

        <#list tradeItems as tradeItem>
            <tr>
                <td>${tradeItem.open}</td>
                <td>${tradeItem.high}</td>
                <#--TODO.add another columns..-->
            </tr>
        </#list>
    </table>
</@common.page>