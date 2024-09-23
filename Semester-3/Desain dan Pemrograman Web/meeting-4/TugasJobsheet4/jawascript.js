function changeHeaderTitle() {
  var result = prompt("Masukkan judul baru", "Konnchiwa~ Sekai~");
  if (result != null) {
    document.getElementById("header-title").textContent = result;
  }
}

var minutes = 0;
var seconds = 0;

function incrementSeconds() {
  var timeSecs = document.getElementById("time-secs");
  seconds += 1;
  if (seconds >= 59) {
    minutes += 1;
    seconds = 0;
  }
  timeSecs.innerText =
    (minutes > 0 ? minutes + " Menit " : "") + seconds + " Detik";
  console.log(seconds);
}
