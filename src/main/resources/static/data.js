$(document).ready(function() {

   var mytable = $('#atmLocations').DataTable( {
    ajax: "./locations",
    "sAjaxDataProp" : "list",
    columns: [
    { data: "address.street" },
    { data: "address.housenumber" },
    { data: "address.postalcode" },
    { data: "address.city" },
    { data: "address.geoLocation.lat" },
    { data: "address.geoLocation.lng" },
    { data: "distance" },
    { data: "type" }
  ],
  dom: 'Bfrtip'
    } );

} );