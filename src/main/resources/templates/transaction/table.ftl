<#import "../common/page.ftl" as common>

<@common.page>
    <h2>Trade Transactions:</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Sticker</th>
            <th scope="col">Amount</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <#list transactions as transaction>
            <tr>
                <th scope="row">${transaction.sticker}</th>
                <td>${transaction.amount}</td>
                <td>${transaction.price}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@common.page>