<template>
    <v-container>
       <DeudasRe></DeudasRe>
       <v-row>
         <v-col cols="12" sm="6">
           <h1 class="big-number">{{ totalactual }}</h1>
           <v-btn color="primary" :height="55" :width="300" @click="pagar">Pagar</v-btn>
         </v-col>
       </v-row>
       <v-row>
         <v-col cols="12">
           <v-data-table :headers="headers" :items="items">
             <template v-slot:item.fecha="{ item }">
               {{ obtenerFecha(item.cuota, items.indexOf(item)) }}
             </template>
           </v-data-table>
         </v-col>
       </v-row>
    </v-container>
   </template>
   
   <script>
import DeudasRe from '../components/DeudasRe.vue';
/* import axios from "axios"; */


   export default {
    data() {
        return {
            title: "Title",
            text: "Text",
            headers: [
                { text: "Cuota", value: "cuota" },
                { text: "Fecha", value: "fecha" },
            ],
            items: [
                { cuota: 1000, fecha: null },
                { cuota: 1000, fecha: null },
                { cuota: 1000, fecha: null },
            ],
            //items: [],
        };
    },
    /* mounted: {
      //aqui se obtiene la informacion para las tablas
      this.getData();
    }, */
    computed: {
      totalactual(){
        if(this.items.length === 0){
          return 0;
        }
        else{
          return this.items[0].cuota;
        }
      },
      cantidadTotal() {
        if (this.items.length === 0) {
          return 0;
        }
         return this.items.reduce((total, item) => total + item.cuota, 0);
        }, 
      },
    methods: {
        obtenerFecha(cuota, monthDifference) {
            const dueDate = new Date();
            dueDate.setMonth(dueDate.getMonth() + monthDifference);
            dueDate.setDate(1);
            //dueDate.setMonth(dueDate.getDate());
            return dueDate.toLocaleDateString();
          },
        pagar() {
            // logica para pagar
            console.log("Pagar");
          },
        getData(){
          axios.get("YOUR_API_URL").then((response) => {
            this.items = response.data.map((item) => {
              return {
                cuota: item.cuota,
                };
              });

            });
          },
        },
    components: { DeudasRe }
};
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