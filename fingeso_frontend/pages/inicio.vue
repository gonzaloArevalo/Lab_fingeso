<template>
    <div>
      <h2>Inicio</h2>
      <p>Bienvenido, {{ adminName }}</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        adminName: '', // Deberías obtener este valor al iniciar sesión
      };
    },
    created() {
      // Aquí podrías hacer una solicitud para obtener la información del administrador logueado
      // y actualizar el valor de adminName
    },
  };
  </script>