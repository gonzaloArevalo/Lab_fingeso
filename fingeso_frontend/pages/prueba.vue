

<script>
export default {
  name: 'prueba',
  data() {
    return {
      userType: '',
      correo: '',
      contrasena: '',
      user: null,
    };
  },
  created() {
    // Accede a los parámetros de la ruta en el ciclo de vida created
    this.correo = this.$route.params.correo;
    this.contrasena = this.$route.params.contrasena;
    this.userType = this.$route.params.userType;
    this.user = this.$route.params.user;

    // Llama al método para obtener datos
  },
};
</script>

<template>
  <div>
    <h1 v-if="user"> HOLA USUARIO {{ user }} </h1>
  </div>
</template>