


<template>
    <div>
        <ul>
            <li v-for="admin in admins" :key="admin.id">
                {{ admin.nombre }}
            </li>
        </ul>
    </div>
</template>

<script>
   import axios from 'axios'
   
   export default {
    name: 'Admins',
    data:function(){
        return {
            admins: []
        }
    },
    methods:{
        getData: async function() {
            let response = await this.$axios.get("/admin/getAll");
            this.admins = response.data;
        }

    },
    created:function(){
        this.getData();
    },

    
   }
   </script>