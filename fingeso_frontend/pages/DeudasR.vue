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
           <v-data-table :headers="headers" :items= deuda>
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
import axios from "axios";


   export default {
    data() {
        return {
            title: "Title",
            text: "Text",
            headers: [
                { text: "Cuota", value: "cuota" },
                { text: "Fecha", value: "fecha" },
            ],
            /* items: [
                { cuota: 1000, fecha: null },
                { cuota: 1000, fecha: null },
                { cuota: 1000, fecha: null },
            ], */
            deuda: [],
        };
    },
    computed: {
      totalactual(){
        return this.deuda.length === 0 ? 0 : this.deuda[0].cuota;
      },
      },
    methods: {
        obtenerFecha(cuota, monthDifference) {
            const dueDate = new Date();
            dueDate.setMonth(dueDate.getMonth() + monthDifference);
            dueDate.setDate(1);
            return dueDate.toLocaleDateString();
          },
        pagar() {
            // logica para pagar
            console.log("Pagar");
            window.location.href = 'https://login.portales.bancochile.cl/login?state=hKFo2SA0el9rYmtodjYtZEpVdWRvVUstREtwNEIyRk1OcGRYc6FupWxvZ2luo3RpZNkgUC1hTkJUYkNnajA5SkxKcEdYX2tNQzZZb28yeWJGdkejY2lk2SBmUDdKVmRvcGV2VGFvZmJYcmZrMUZUZW9sVTVYTDE2NQ&client=fP7JVdopevTaofbXrfk1FTeolU5XL165&protocol=oauth2&response_type=code&scope=openid%20email%20profile&redirect_uri=https%3A%2F%2Fportalpersonas.bancochile.cl%3A443%2Fmibancochile-web%2Fredirect_uri&nonce=1qN_t9F5pbbt2ebPMwdBO31Xf8g1kHSJpIh5pfvYYlg';
          },
        /* getData(){
          axios.get("YOUR_API_URL").then((response) => {
            this.items = response.data.map((item) => {
              return {
                cuota: item.cuota,
                };
              });

            });
          }, */
        getData: async function() {
          let response = await this.$axios.get("/deudas/getAll");
          this.deuda = [];
          for (let item of response.data) {
            let cuota = item.cuota;
            for (let i = 0; i < 12; i++){
              const dueDate = new Date();
              dueDate.setMonth(dueDate.getMonth() + i);
              dueDate.setDate(1);
              this.deuda.push({
                cuota: cuota,
                fecha: dueDate.toLocaleDateString(),
              });
            }
          } 
        },
        created:function(){
          this.getData();
        }
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