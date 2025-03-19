using API.Services;

var builder = WebApplication.CreateBuilder(args);

// Habilitar CORS correctamente
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        policy => policy
            .AllowAnyOrigin()  // Permitir cualquier origen (útil para desarrollo)
            .AllowAnyHeader()
            .AllowAnyMethod());
});

// Agregar servicios
builder.Services.AddOpenApi();
builder.Services.AddControllers();
builder.Services.AddControllersWithViews();
builder.Services.AddSingleton<InterpreterService>();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
}

// Habilitar archivos estáticos
app.UseStaticFiles();

// 📌 **IMPORTANTE**: Usa `UseRouting()` antes de `UseCors()`
app.UseRouting();

// 📌 **IMPORTANTE**: Habilitar CORS después de `UseRouting()`
app.UseCors("AllowAll");

// Seguridad y autenticación
app.UseAuthorization();

// Usar redirección HTTPS (opcional)
app.UseHttpsRedirection();

// Mapear controladores
app.MapControllers();

// Agregar rutas
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
