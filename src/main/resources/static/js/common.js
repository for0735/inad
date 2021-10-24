/*
    Menu 관련 이벤트 시작
*/
document.querySelectorAll('nav ul li div:not(:only-child)').forEach((el, index) => {
    el.addEventListener("click", function(event) {
        let thisDropdown = this.nextElementSibling;
        thisDropdown.classList.toggle('show');

        document.querySelectorAll('.nav-dropdown').forEach((el, index) => {
            if(!el.isEqualNode(thisDropdown)) {
                el.classList.remove('show');
            }
        });

        event.stopPropagation();
    });
});

document.querySelector('html').addEventListener("click", function() {
    document.querySelectorAll('.nav-dropdown').forEach((el, index) => {
        el.classList.remove('show');
    });
});

document.querySelector('#nav-toggle').addEventListener("click", function() {
    document.querySelector('.nav-list').classList.toggle('show');
    this.classList.toggle('active');
});
/*
    Menu 관련 이벤트 종료
*/

// Always current year
document.querySelector('#this-year').innerHTML = new Date().getFullYear();


/*
	다운로드 로직
*/
function downloadFile(fileName, originalName){
	location.href="/common/file-download?fileName="+fileName+"&originalName="+originalName;
}