<template>
  <div class="min-h-screen bg-gray-900 text-white p-6 space-y-6">
    <div class="bg-gray-800 p-4 rounded-lg shadow">
      <h1 class="text-3xl font-bold text-white">Vulkan4j Module Customizer</h1>
    </div>

    <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
      <div class="space-y-2">
        <label class="block text-lg font-medium">Version:</label>
        <select v-model="selectedVersion"
                class="w-full p-2 bg-gray-700 text-white rounded border border-gray-600 focus:outline-none focus:ring-2 focus:ring-blue-500">
          <option v-for="version in versions" :key="version" :value="version">
            {{ version }}
          </option>
        </select>
      </div>

      <div class="space-y-2">
        <label class="block text-lg font-medium">Select Modules:</label>
        <div class="space-y-2 pr-2">
          <label v-for="(name, key) in availableModules" :key="key" class="flex items-center space-x-2">
            <input type="checkbox" v-model="selectedModules" :value="key"
                   class="form-checkbox h-5 w-5 text-blue-500 bg-gray-800 border-gray-600 focus:ring-blue-500">
            <span>{{ name }}</span>
          </label>
        </div>
      </div>

      <div class="space-y-2">
        <label class="block text-lg font-medium">Build Tool:</label>
        <div class="space-y-2">
          <label class="flex items-center space-x-2">
            <input type="radio" value="gradle" v-model="buildTool"
                   class="form-radio text-blue-500 bg-gray-800 border-gray-600 focus:ring-blue-500">
            <span>Gradle</span>
          </label>
          <label class="flex items-center space-x-2">
            <input type="radio" value="maven" v-model="buildTool"
                   class="form-radio text-blue-500 bg-gray-800 border-gray-600 focus:ring-blue-500">
            <span>Maven</span>
          </label>
        </div>
      </div>
    </div>

<div class="flex flex-col md:flex-row gap-4 mt-4">
  <button @click="generateConfig"
          class="w-full md:w-auto px-6 py-2 bg-blue-600 hover:bg-blue-700 text-white font-semibold rounded transition">
    Generate Config
  </button>
  <button @click="handleGenerateAndCopy"
          class="w-full md:w-auto px-6 py-2 bg-green-600 hover:bg-green-700 text-white font-semibold rounded transition">
    Copy Config
  </button>
</div>


    <pre
      class="bg-gray-800 text-green-200 p-4 rounded-lg whitespace-pre-wrap font-mono text-sm leading-relaxed overflow-x-auto border border-gray-700">
<code>{{ generatedCode }}</code>
    </pre>
  </div>
</template>



<script setup>
import { ref, computed,watch,nextTick } from "vue";
import libraryJson from '../data/library.json' 

const versions = ref(Object.keys(libraryJson.library.versions).sort((a, b) => b.localeCompare(a)));
const selectedVersion = ref(versions.value[0]);

const availableModules = computed(() => libraryJson.library.versions[selectedVersion.value] || []);
const selectedModules = ref([]);
const buildTool = ref("maven");
const useCustomRepo = ref(false);
const generatedCode = ref("");
const groupId = ref("club.doki7");


watch(selectedVersion, () => {
    selectedModules.value = selectedModules.value.filter((key) => availableModules.value[key] !== undefined);
});

function generateConfig() {
    const modules = selectedModules.value.sort().map((key) => {
    console.log(key, availableModules.value[key]);
        return availableModules.value[key];
    }).filter(value => value !== undefined);
    console.log(modules ,availableModules.value);
    if (buildTool.value === "gradle") {
        
    } else {
        generateMavenCode(modules);
    }
}

function generateMavenCode(modules) {
    const maven = [];
    if (useCustomRepo.value) {
        maven.push(`<repositories>`);
        maven.push(`  <repository>`);
        maven.push(`    <id>custom</id>`);
        maven.push(`    <url></url>`);
        maven.push(`  </repository>`);
        maven.push(`</repositories>\n`);
    }

    maven.push(`<dependencies>`);
    for (const mod of modules) {
        maven.push(`  <dependency>`);
        maven.push(`    <groupId>${groupId.value}</groupId>`);
        maven.push(`    <artifactId>${mod}</artifactId>`);
        maven.push(`    <version>${selectedVersion.value}</version>`);
        maven.push(`    <scope>compile</scope>`);
        maven.push(`  </dependency>`);
    }
    maven.push(`</dependencies>`);

    generatedCode.value = maven.join("\n");
}

function handleGenerateAndCopy() {
  generateConfig();
  nextTick(() => {
    navigator.clipboard.writeText(generatedCode.value).then(() => {
      alert("Copied to clipboard!");
    }).catch(() => {
      alert("Failed to copy.");
    });
  });
}

</script>

<style scoped>
</style>
