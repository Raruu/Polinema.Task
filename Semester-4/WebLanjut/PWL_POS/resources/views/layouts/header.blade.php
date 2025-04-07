<nav class="main-header navbar navbar-expand">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
            <a href="{{ url('/') }}" class="nav-link">
                <i class="fas fa-user"></i>
                <span class="text-muted">Level/Username:</span>
                <b>{{ Auth::user()->getRole() }}/{{ Auth::user()->username }}</b>
            </a>
        </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                <i class="fas fa-expand-arrows-alt"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#" role="button" data-toggle="button" aria-pressed="false"
                onclick="toggleDarkMode()">
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
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="{{ url('logout') }}" role="button" style="transition: color 0.3s;"
                onmouseover="this.style.color='red'" onmouseout="this.style.color=''">
                <i class="fas fa-sign-out-alt"></i>
            </a>
        </li>
    </ul>
</nav>
