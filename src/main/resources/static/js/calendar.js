let currentCalendar = 0;

const calendars = document.querySelectorAll('.mounth-calendar');
const tooltip = document.querySelector('.tooltip');

calendars.forEach((calendar) => {
    const prevBtn = calendar.querySelector('.prev');
    const nextBtn = calendar.querySelector('.next');
    const activeDates = calendar.querySelectorAll('.active');


    prevBtn.addEventListener('click', function() {
        if(currentCalendar <= 0) {
            return;
        }

        currentCalendar--;
        calendar.classList.remove('active-calendar');
        calendars[currentCalendar].classList.add('active-calendar');
    });

    nextBtn.addEventListener('click', function() {
        if(currentCalendar >= calendars.length - 1) {
            return;
        }

        currentCalendar++;
        calendar.classList.remove('active-calendar');
        calendars[currentCalendar].classList.add('active-calendar');
    });


    activeDates.forEach(date => {
        date.addEventListener('mousemove', function(e) {
            tooltip.innerText = this.dataset.title;
            tooltip.style.top = (e.clientY + 15) + 'px';
            tooltip.style.left= (e.clientX + 15) + 'px';
    
        });
    
        date.addEventListener('mouseenter', () => {
            tooltip.style.display = 'block';
        });
    
        date.addEventListener('mouseleave', () => {
            tooltip.style.display = 'none';
        });
    })
});