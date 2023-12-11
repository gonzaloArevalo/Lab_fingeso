<template>

  <div class ="contenedorTres">
    <div class ="col-sm">
      <div v-for="(item, index) in items" :key="index">
        <a>
        <button class="botonDos"><span>{{item.monto}} </span></button>
        </a>
      </div>
    </div>

    </div>
   
</template>
   
   <script>


import axios from "axios";


export default {
    layout: 'layout2',
      //Función que contiene los datos del componente
      data() {
          return{
              //Lista de ítems a mostrar
              items:[]
          }
      },
      methods:{
          //Función asíncrona para consultar los datos
          getData: async function(){
              try {
                  let response = await this.$axios.get('/deuda/getAll');
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
<style>
.container {
display: flex;
flex-direction: column;
justify-content: center;
/* align-items: center; */
}
.big-number {
align-self: flex-start;
margin: 0;
padding: 0;
font-size: 56px;
text-align: left;
}
</style>