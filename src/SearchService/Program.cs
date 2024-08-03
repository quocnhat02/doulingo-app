using MongoDB.Driver;
using MongoDB.Entities;
using SearchService;
using SearchService.Data;
using SearchService.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();

// Configure MongoDB
builder.Services.AddSingleton<IMongoClient>(serviceProvider =>
{
    var connectionString = builder.Configuration.GetConnectionString("MongoDbConnection");
    var settings = MongoClientSettings.FromConnectionString(connectionString);

    settings.MaxConnectionPoolSize = 100;

    return new MongoClient(settings);
});

// Register DbInitializer
builder.Services.AddSingleton<DbInitializer>();

var app = builder.Build();

app.UseAuthorization();

app.MapControllers();

// Initialize database and create indexes
await InitializeDatabaseAsync(app);

app.Run();

async Task InitializeDatabaseAsync(WebApplication app)
{
    using var scope = app.Services.CreateScope();
    var dbInitializer = scope.ServiceProvider.GetRequiredService<DbInitializer>();

    try
    {
        await dbInitializer.InitializeDatabaseAsync();
        Console.WriteLine("Database initialization and indexing complete.");
    }
    catch (Exception ex)
    {
        Console.WriteLine($"An error occurred during database initialization: {ex.Message}");
    }
}