<div class="position-fixed float-left" style="bottom: 0px; left: 10px;">
    <div class="card d-flex align-items-end card-mode">
        <button href="#" role="button" data-toggle="button" aria-pressed="false" onclick="toggleDarkMode()">
            <i class="fas" id="mode-icon"></i>
            <script>
                const modeIcon = document.getElementById('mode-icon');
                const changeMode = (isDark) => {
                    modeIcon.classList.remove('fa-sun', 'fa-moon');
                    if (isDark) {
                        modeIcon.classList.add('fa-moon');
                    } else {
                        modeIcon.classList.add('fa-sun');
                    }
                }
                changeMode(localStorage.getItem('dark_mode') === 'true');
                window.addEventListener('localStorageSetItem', (event) => {
                    if (event.detail.key == 'dark_mode') {
                        changeMode(event.detail.value);
                    }
                });
            </script>
        </button>
    </div>
</div>
