<script>
    if (localStorage.getItem('dark_mode') === 'true') {
        document.documentElement.classList.add('dark');
    }

    const origLocalStorageSetItem = localStorage.setItem;
    localStorage.setItem = function(key, value) {
        const event = new CustomEvent('localStorageSetItem', {
            detail: {
                key: key,
                value: value
            }
        });
        window.dispatchEvent(event);
        return origLocalStorageSetItem.apply(this, arguments);
    }

    const toggleDarkMode = () => {
        document.documentElement.classList.toggle('dark');
        localStorage.setItem('dark_mode', document.documentElement.classList.contains('dark'));
    }
</script>
