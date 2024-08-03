using MongoDB.Driver;
using SearchService.Models;

namespace SearchService.Data;

public class DbInitializer
{
    private readonly IMongoClient _mongoClient;

    public DbInitializer(IMongoClient mongoClient)
    {
        _mongoClient = mongoClient;
    }

    public async Task InitializeDatabaseAsync()
    {
        var database = _mongoClient.GetDatabase("SearchDb");
        await CreateIndexesAsync(database);
    }

    private async Task CreateIndexesAsync(IMongoDatabase database)
    {
        var collection = database.GetCollection<Item>("Items");

        var indexKeys = Builders<Item>.IndexKeys
            .Text(x => x.Make)
            .Text(x => x.Model)
            .Text(x => x.Color);

        var indexOptions = new CreateIndexOptions { Unique = false };
        var indexModel = new CreateIndexModel<Item>(indexKeys, indexOptions);

        await collection.Indexes.CreateOneAsync(indexModel);
    }
}
