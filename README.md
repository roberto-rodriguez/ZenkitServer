 

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
