const websocket = new WebSocket(`ws://${window.location.host}/ws`);
const clocks = Array.from(document.getElementsByClassName("Clock"));
websocket.addEventListener("message", (e) => clocks.forEach(clock => clock.innerText = new Date(parseInt(e.data)).toLocaleString()));