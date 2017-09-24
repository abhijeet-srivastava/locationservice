using Refit;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Com.Cvent.LocationService.Client
{
	/// <summary>
	/// A client to interface with authors of a given project in the Location Service API.
	/// </summary>
    public interface IEntityClient
    {
		[Get("/entity/{entityId}")]
		Task<Object> GetEntity([AliasAs("entityId")] Guid entityId);
    }
}