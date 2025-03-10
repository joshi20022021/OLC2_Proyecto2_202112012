using API.Services;

var builder = WebApplication.CreateBuilder(args);

// Habilitar CORS
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll",
        policy => policy.WithOrigins("http://localhost:5089", "http://localhost:3000") // Cambia si React está en otro dominio
                        .AllowAnyHeader()
                        .AllowAnyMethod());
});

// Agregar servicios
builder.Services.AddOpenApi();
builder.Services.AddControllers();
builder.Services.AddControllersWithViews();
builder.Services.AddSingleton<InterpreterService>();

var app = builder.Build();

// Usar CORS antes de cualquier middleware
app.UseCors("AllowAll");

app.UseStaticFiles();
app.UseRouting();
app.UseAuthorization();

if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();
app.MapControllers();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
