pointSize :  Diameter of displayed points in pixels. Use zero to hide all points. You can override values for individual series using the series property.



### Creating and Populating a DataTable
1. create column
```
var data = new google.visualization.DataTable();

//Syntax : data.addColumn('DataType','Header Name')

// Declare columns
data.addColumn('string', 'Employee Name');
data.addColumn('datetime', 'Hire Date');

// Add data.
data.addRows([
  ['Mike', {v:new Date(2008,1,28), f:'February 28, 2008'}], // Example of specifying actual and formatted values.
  ['Bob', new Date(2007,5,1)],                              // More typically this would be done using a
  ['Alice', new Date(2006,7,16)],                           // formatter.
  ['Frank', new Date(2007,11,28)],
  ['Floyd', new Date(2005,3,13)],
  ['Fritz', new Date(2011,6,1)]
]);
```