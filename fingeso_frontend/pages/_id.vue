<template>
    <div>
      <h1>Detalles del administrador</h1>
      <p>ID: {{ admin.id_admin }}</p>
      <p>Nombre: {{ admin.nombre }}</p>
      <p>Rut: {{ admin.rut }}</p>
      <p>Correo: {{ admin.correo }}</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        admin: {},
      };
    },
    async asyncData({ params }) {
      const id_admin = params.id_admin;
      const response = await this.$axios.get(`/admin/findByID/${id_admin}`);
      const admin = response.data;
      return { admin };
    },
  };
  </script>