function setData(val){
    var newClientData = {
        id: $("#client_id").val(),

        name: $("#name").val().substr(
                $("#name").val().indexOf(":") + 1),

        gender: $("#gender").val().substr(
                $("#gender").val().indexOf(":") + 1),

        height: $("#height").val().substr(
                $("#height").val().indexOf(":") + 1),

        weight: $("#weight").val().substr(
                $("#weight").val().indexOf(":") + 1),

        lifeStyle: $("#lifeStyle").val().substr(
                $("#lifeStyle").val().indexOf(":") + 1)
    };

    $.post(
        val,
        newClientData,
        function(result){
            console.log("Client data changed successfully");
        }
    );
}

var state = 1;

function enableInput(val){
    state *= -1;
    if(state == -1){
        $('.personal_data input').prop('disabled', false);
        $('#config_personal_data').html('<span class="glyphicon glyphicon-ok"></span>');
    }else{
        $('#config_personal_data').html('<span class="glyphicon glyphicon-cog"></span>');
        $('.personal_data input').prop('disabled', true);
        setData(val);
    }
}