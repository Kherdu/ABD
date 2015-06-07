xquery version "3.0";

for $edicion in //edicion
return data($edicion/@numero)