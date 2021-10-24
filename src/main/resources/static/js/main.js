let swiper = new Swiper(".main-swiper", {
    loop: true,
    autoplay: {
        delay: 3000,
        disableOnInteraction: false,
    },
    keyboard: {
        enabled: true,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
});

document.addEventListener('DOMContentLoaded', function() {
    let calendarEl = document.getElementById('calendar');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'ko-kr',
        headerToolbar: {
            left: "prev,next today",
            center: "title",
            right: "dayGridMonth,listYear"
        },
        selectable: true
    });

    calendar.render();
});