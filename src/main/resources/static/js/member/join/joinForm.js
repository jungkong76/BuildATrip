var signCode = '';
var mem_id = '';
function send() {
    event.preventDefault();

    let email1 = $('#email1').val();
    let email2 = $('#email2').val();

    if (email1 === '' || email2 === '') {
        event.preventDefault();
        alert('이메일을 입력해주세요.');
    } else {
        mem_id = email1 + "@" + email2;

        $.ajax({ //중복 체크
            type: 'POST',
            url: '/member/join/checkEmail',
            dataType: 'json',
            data: {"mem_id": mem_id},
            success: function (success) {
                if (success) {
                    $.ajax({ // 인증코드 전송
                        type: 'POST',
                        url: '/member/join/sendCertCode',
                        dataType: 'JSON',
                        data: {"mem_id": mem_id},
                        success: function (result) {
                            if (result.success) {
                                signCode = result.signCode;
                                alert('입력하신 메일로 인증코드가 전송되었습니다.');
                                $('#email1').prop('disabled', true);
                                $('#email2').prop('disabled', true);
                                $('#selectAdd').prop('disabled', true);
                                $('.send').css('display', 'none');
                                $('#certification').css('display', 'block');
                            } else {
                                alert('오류가 발생했습니다.\n다시 시도해주세요.')
                            }
                        },
                    });
                } else {
                    alert('이미 사용중인 계정입니다.\n다른 이메일을 입력해주세요.')
                }
            }
        });
    }
}

$('#selectAdd').on('change', function () {
    if ($('#selectAdd').val() !== '999') {
        $('#email2').val($(this).val());
        $('#email2').prop('disabled', true);
    } else {
        $('#email2').val('');
        $('#email2').prop('disabled', false);
    }
});

function check(){
    event.preventDefault();
    let inputCode = $('#inputCode').val();
    if(inputCode === signCode){
        alert('인증에 성공했습니다.');
        $('#certification').css('display', 'none');
        $('.email_valid').addClass('right')
        $('.email_valid').text('인증 완료');
    } else {
        alert('인증에 실패했습니다.\n이메일에 전송된 코드를 입력해주세요.');
    }
}

$('#email1').on('input', function () {
    let email1 = $(this);
    const pattern = /^[A-Za-z0-9]+$/;
    if(email1.val() !== '' && !pattern.test(email1.val())){
        alert('숫자와 영문자만 입력할 수 있습니다.');
        email1.val('');
    }
});

$('#email2').on('input', function () {
    let email2 = $(this);
    const pattern = /^[A-Za-z.]+$/;
    if(email2.val() !== '' && !pattern.test(email2.val())){
        alert("영문자와 문자 '.'만 입력할 수 있습니다.");
        email2.val('');
    }
});

$('#mem_password').on('input', function () {
    let password = $(this);
    const pattern = /^[A-Za-z0-9]+$/;
    if (password.val().trim() === '') {
        $('.pw_valid').text('').removeClass('right wrong');
        return;
    } else{
        $('.pw_valid').text('').removeClass('right wrong');
        if(password.val().length > 0 && password.val().length < 6){
            $('.pw_valid').text('6자 이상이어야 합니다.');
            $('.pw_valid').addClass('wrong');
        } else {
            $('.pw_valid').text('사용 가능한 비밀번호입니다.');
            $('.pw_valid').addClass('right');
        }
    }
});

$('#mem_name').on('input', function () {
    let mem_name = $(this).val();
    if (mem_name.trim() === '') {
        $('.name_valid').text('').removeClass('right wrong');
        return;
    } else {
        $.ajax({
            type: 'POST',
            url: '/member/join/checkNickName',
            dataType: 'json',
            data: {"mem_name": mem_name},
            success: function (res) {
                $('.name_valid').text('').removeClass('right wrong');
                if (res) {
                    $('.name_valid').text('사용 가능한 별명입니다.');
                    $('.name_valid').addClass('right');
                } else {
                    $('.name_valid').text('이미 사용중인 별명입니다.');
                    $('.name_valid').addClass('wrong');
                }
            }
        })
    }
});

function enroll(){
    if($('.email_valid').text() !== '인증 완료'){
        event.preventDefault();
        alert('메일을 인증해주세요!');
    }
    else if($('.name_valid').text() !== '사용 가능한 별명입니다.'){
        event.preventDefault();
        alert('사용 가능한 별명을 입력해주세요!');
    }

    else if($('#mem_age').val() === '999'){
        event.preventDefault();
        alert('연령을 선택해주세요!');
    }

    else if($('#mem_gender').val() === '999'){
        event.preventDefault();
        alert('성별을 선택해주세요!');
    } else {
        $('#mem_id').val(mem_id);
        alert('회원가입이 완료되었습니다.');
    }
}