<#import "../common/page.ftl" as common>

<@common.page>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
        Create Trade Transaction
    </button>
    <!-- Modal -->
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">

            <form action="/transaction/create" method="post">

                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Trade Transaction</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="sticker">Company Sticker:</label>
                            <input type="text" class="form-control" aria-describedby="stickerHelp" name="sticker">
                            <small id="stickerHelp" class="form-text text-muted">Please enter company Sticker.</small>
                        </div>
                        <div class="form-group">
                            <label for="amount">Amount:</label>
                            <input type="number" class="form-control" aria-describedby="amountHelp" name="amount">
                            <small id="amountHelp" class="form-text text-muted">Please enter stocks amount.</small>
                        </div>
                        <div class="form-group">
                            <label for="price">The Latest Close Price: ${price} USD</label>
                            <input type="number" class="form-control" name="price"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>

            </form>
        </div>
    </div>

    <h2>Trades Items:</h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Period</th>
            <th scope="col">Open</th>
            <th scope="col">High</th>
            <th scope="col">Low</th>
            <th scope="col">Close</th>
            <th scope="col">Vilume</th>
        </tr>
        </thead>
        <tbody>
        <#list tradeItems as tradeItem>
            <tr>
                <th scope="row">${tradeItem.period}</th>
                <td>${tradeItem.open}</td>
                <td>${tradeItem.high}</td>
                <td>${tradeItem.low}</td>
                <td>${tradeItem.close}</td>
                <td>${tradeItem.volume}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@common.page>