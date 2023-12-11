<script>
export default {
  name: 'user4',
  data() {
    return {
      id: '',
      user: null,
    };
  },
  created() {
    // Accede a los parámetros de la ruta en el ciclo de vida created
    this.user = this.$route.params.user;

    // Llama al método para obtener datos
  },
};
</script>




<template>


    <h1 v-if="user"> HOLA {{ user }}</h1>


    
</template>