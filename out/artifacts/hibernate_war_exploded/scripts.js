function loadItems() {
    $(
        $.ajax('./json', {
            method: 'get',
            dataType: "json",
            success: function (data) {
                var json = data;
                var res =
                    "<tr>" +
                    "<th>Id</th>" +
                    "<th>Description</th>" +
                    "<th>Date</th>" +
                    "<th>Done</th>" +
                    "</tr>";
                document.getElementById("table").innerHTML = res;
                for (var i in json) {
                    console.log(i)
                    $('#table tr:last').after(
                        "<tr>" +
                        "<th> + json[i].id + </th>" +
                        "<th> + json[i].description + </th>" +
                        "<th> + json[i].date + </th>" +
                        "<th> + json[i].done + </th>" +
                        "</tr>"
                    );
                }
            }
        })
    );
}
function createItem() {
    $(
        $.ajax('./json', {
                method : 'post',
                data : {
                    description : $('#description').val(),
                },
                complete: function() {loadItems()}
            }
        )
    );
    return true
}