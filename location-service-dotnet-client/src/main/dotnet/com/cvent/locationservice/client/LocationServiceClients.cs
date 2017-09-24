using Newtonsoft.Json.Converters;
using Refit;
using System;
using System.Collections.Generic;

namespace Com.Cvent.LocationService.Client
{
    /// <summary>
    /// The set of Refit client interfaces which manage interactions with the Location Service service.
    /// </summary>
    public static class LocationServiceClients
    {
        private static HashSet<Type> _clientTypes;
		private static RefitSettings _settings;

        /// <summary>
        /// The set of Refit interfaces class types which can be used to interfact with the Location Service Service. This is used by
        /// the Cvent.Framework.Client RefitClientModule class to hook in client generation via autofac. If a new Refit client interface is
        /// created this list can be updated for inclusion. Any system using the autofac should see this client upon package update.
        /// </summary>
        public static HashSet<Type> ClientTypes
        {
            get
            {
                if (_clientTypes == null)
                {
                    _clientTypes = new HashSet<Type>();
                    _clientTypes.Add(typeof (IEntityClient));
                }
                return _clientTypes;
            }
        }

		public static RefitSettings Settings
		{
			get
			{
				if (_settings == null)
				{
					_settings = new RefitSettings();
					_settings.JsonSerializerSettings = new Newtonsoft.Json.JsonSerializerSettings {
						Converters = {
							new IsoDateTimeConverter
							{
								DateTimeFormat = "yyyy'-'MM'-'dd'T'HH':'mm':'ss.fff'Z'"
							}
						}
					};
				}
				return _settings;
			}
		}
    }
}