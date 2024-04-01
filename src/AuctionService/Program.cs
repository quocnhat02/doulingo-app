using AuctionService;
using AuctionService.Data;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// builder.WebHost.UseUrls("http://*:80");

// Add services to the container.
builder.Services.AddControllers();

builder.Services.AddDbContext<AuctionDBContext>(opt =>
{
    opt.UseNpgsql(builder.Configuration.GetConnectionString("DefaultConnectionString"));
});

var app = builder.Build();

// Configure the HTTP request pipeline.
app.UseAuthorization();

app.MapControllers();

try
{
    DbInitializer.InitDb(app);
}
catch (Exception e)
{
    Console.WriteLine(e);
}

app.Run("http://localhost:7002");
