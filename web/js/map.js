function initMap() {
  var myLatLng = {lat: 42.975814, lng: -82.347485};

  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 12,
    center: myLatLng
  });

  var marker = new google.maps.Marker({
    position: myLatLng,
    map: map,
    title: 'LambtonCollege'
  });
}