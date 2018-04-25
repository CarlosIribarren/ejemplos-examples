$( document ).ready(function() {

  $('.importe').autoNumeric('init',{
    aSep: '.',
    aDec: ',',
    mDec: 0,
    vMin: '0.00',
    wEmpty: 'zero',
    lZero: 'deny',
    anDefault: '0'
  }); 

});