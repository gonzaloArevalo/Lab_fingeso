<script>
export default {
  layout: 'layout2',
  name: 'user2',
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
<div>
    <h1 v-if="user" class = "user-name"> Bienvenido {{ this.user.nombre }}</h1>
  <p>
    Usted acaba de iniciar la aplicación, Esta diseñada con el fin de favorecer el
    uso simple de las cuentas de la comunidad establecida para que tenga una experiencia
    más fluida, dentro de la barra de tareas encontrara las opciones para salir de esta
    como para ver sus deudas pendientes y efectuar los pagos antes de que acumulen intereses,
    finalmente recuerde siempre tener un buen día.
    Gracias por su atención.
  </p>
</div>
</template>

<style scoped>
.user-name {
  font-weight: bold;
  color: #3498db;
  margin-bottom: 45px;
}
</style>
