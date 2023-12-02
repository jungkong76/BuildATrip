
function send(){
    let email1 = document.getElementById("email1").value;
    let email2 = document.getElementById("email2").value;
let email = email1+"@"+email2;
}

$('#selectAdd').on('change',function (){
   if($('#selectAdd').val() !== '999'){
       $('#email2').val($(this).val());
       $('#email2').prop('disabled', true);
   } else {
       $('#email2').val('');
       $('#email2').prop('disabled', false);
   }
});