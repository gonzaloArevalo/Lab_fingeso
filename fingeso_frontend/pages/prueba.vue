

<script>
export default {
  name: 'prueba',
  data() {
    return {
      correo: '',
      contrasena: '',
      admin: null,
      number: 2,
    };
  },
  methods: {
    async getData() {
      try {
        console.log(this.number);
        let response = await this.$axios.get("/admin/findByID/" + this.number);
        this.admin = response.data;
        console.log(response);
      } catch (error) {
        console.log('error', error);
      }
    },
  },
  created() {
    // Accede a los parámetros de la ruta en el ciclo de vida created
    this.correo = this.$route.params.correo;
    this.contrasena = this.$route.params.contrasena;

    // Llama al método para obtener datos
    this.getData();
  },
};
</script>

<template>
  <div>
    <h1 v-if="admin"> HOLA {{ admin.nombre }} tu correo es {{ correo }} y tu pass {{ contrasena }} </h1>
  </div>
</template>