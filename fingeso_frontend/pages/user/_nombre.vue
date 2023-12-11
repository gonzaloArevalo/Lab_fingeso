<script>
export default {
  data() {
    return {
      userType: '',
      user: null,
    };
  },
  async asyncData({ params }) {
    return { userType: params.userType, user: { nombre: decodeURIComponent(params.nombre) } };
  },
};
</script>

<template>
  <div>
    <h1> HOLA USUARIO {{ userType }}</h1>
    <p>Nombre de usuario: {{ user.nombre }}</p>
  </div>
</template>