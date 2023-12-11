
<template>
    
    <h1> Hola id : {{param}} con nombre {{ items.nombre }} y con correo {{ items.correo }} </h1>

</template>


<script>
export default {
      //Función que contiene los datos del componente
      data() {
          return{
              //Lista de ítems a mostrar
              param: this.$route.params.id,
              items:[],
          }
      },
      methods:{
          //Función asíncrona para consultar los datos
          getData: async function(){
              try {
                  let response = await this.$axios.get('/admin/findByID/' + this.param);
                  this.items  = response.data;
                  console.log(response);
              } catch (error) {
                  console.log('error', error);
              }
          }
      },
      //Función que se ejecuta al cargar el componente
      created:function(){
          this.getData();
      }
  
  }
</script>





