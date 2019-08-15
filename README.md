 

## Setup

<ol>
 <li>Install Postgres SQL</li>
 <li>Create a database named 'db'</li>
 <li>Open this project in Net Beans</li>
 <li>Right click on the project -> 'Resolve dependence problems' (This is the equivalent to 'npm install' for Java)</li>
 <li>Right Click on the project -> 'Clean and Build'</li>
 <li>Right click on the project -> 'Run on Server'</li>
 <li>Copy the url to the Zenkit/config/dev.js</li>
</ol> 

Like this:

module.exports = {
  senkitServerURL: "http://localhost:8088/Front"
};


## API Specification

<b>Entities:</b>
<ul>
 <li>client</li>
 <li>comment</li>
 <li>sprint</li>
 <li>task</li> 
 </ul>
 <br/>
  <br/>
 <b>List:</b> Return one object containing the list: {List: [list of Objects]}
  <br/>
 /<entity>/list?params=[params]
  <br/>
  <br/>
   <b>Load:</b>  Return Object
  <br/>
  /<entity>/load?params=[params]
 
 <br/>
  <br/>
    <b>List of nomenclator</b> Return List of objects [id, name] (Used to load in Combobox)
  <br/>
  /<entity>/nomenclator?params=[params]
 
 
  <br/>
  <br/>
 <b>Syntax for [params]:</b>
 <br/>
 [fieldName]@is@([type])<value>
  <br>
  You can also concatenate more than one params like this:
  [param]@and@[param]@and@[param]...
  
  <br/>
  <br/>
 <b>Types of [type]:</b> 
 <ol>
  <li>(I) - Integer</li>
  <li>(L) - Long</li>
  <li>(d) - Double</li>
  <li>(D) - Date</li>
  <li>(B) - Boolean</li>
  <li>(I) - Integer</li>
  <li>(I) - Integer</li>
  </ol>
 
  <br/>
  <br/>
  <b>Examples:</b>
  <br/>
  Load Sprint where id = 2
  <br/>
  /sprint/load?params=id@is@(I)2
  <br/>
  Load Sprint where active = true
  <br/>
  /sprint/load?params=active@is@(B)true
   <br/>
  List unnactive aprints 
  <br/>
  /sprint/list?params=active@is@(B)false
 <br/>
  List nomenclators <id, name> of active users
  <br/>
  /sprint/nomenclator?params=active@is@(B)true
  
  
  
  
 
 
