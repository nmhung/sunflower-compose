/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fitken.sunflowercompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.composethemeadapter.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import net.fitken.sunflowercompose.adapters.PLANT_LIST_PAGE_INDEX
import net.fitken.sunflowercompose.compose.garden.GardenEmpty
import net.fitken.sunflowercompose.compose.garden.ListGardenPlanting
import net.fitken.sunflowercompose.viewmodels.GardenPlantingListViewModel

@AndroidEntryPoint
class GardenFragment : Fragment() {

    private val viewModel: GardenPlantingListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MdcTheme {
                val plantings = viewModel.plantAndGardenPlantings.observeAsState().value
                if (plantings.isNullOrEmpty()) {
                    GardenEmpty {
                        navigateToPlantListPage()
                    }
                } else {
                    ListGardenPlanting(
                            items = plantings, findNavController()
                    )
                }
            }
        }
    }

    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
                PLANT_LIST_PAGE_INDEX
    }
}
