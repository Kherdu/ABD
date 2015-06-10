xquery version "3.0";

for $edicion in doc("eurovision.xml")/eurovision/edicion 
return data($edicion/@numero)